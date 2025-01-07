import os
import xml.etree.ElementTree as ET
from pathlib import Path

def convert_annotation(xml_path, output_path):
    """
    将单个XML文件转换为YOLO格式
    """
    tree = ET.parse(xml_path)
    root = tree.getroot()
    
    # 获取图片尺寸
    size = root.find('size')
    width = float(size.find('width').text)
    height = float(size.find('height').text)
    
    # 创建输出文件
    output_file = os.path.join(output_path, 
                              os.path.splitext(os.path.basename(xml_path))[0] + '.txt')
    
    with open(output_file, 'w') as out_file:
        # 处理每个目标
        for obj in root.findall('object'):
            # 获取类别名称
            class_name = obj.find('name').text
            
            # 获取边界框坐标
            bbox = obj.find('bndbox')
            xmin = float(bbox.find('xmin').text)
            ymin = float(bbox.find('ymin').text)
            xmax = float(bbox.find('xmax').text)
            ymax = float(bbox.find('ymax').text)
            
            # 计算YOLO格式的坐标
            x_center = (xmin + xmax) / (2.0 * width)
            y_center = (ymin + ymax) / (2.0 * height)
            box_width = (xmax - xmin) / width
            box_height = (ymax - ymin) / height
            
            # 写入文件
            # YOLO格式: <class_id> <x_center> <y_center> <width> <height>
            out_file.write(f"{class_name} {x_center:.6f} {y_center:.6f} {box_width:.6f} {box_height:.6f}\n")

def convert_folder(input_folder, output_folder):
    """
    转换整个文件夹的XML文件
    """
    # 创建输出文件夹
    if not os.path.exists(output_folder):
        os.makedirs(output_folder)
    
    # 遍历所有XML文件
    for xml_file in Path(input_folder).glob('*.xml'):
        try:
            convert_annotation(str(xml_file), output_folder)
            print(f"Successfully converted {xml_file}")
        except Exception as e:
            print(f"Error converting {xml_file}: {str(e)}")

if __name__ == '__main__':
    # 设置输入输出文件夹
    input_folder = './annotations'
    output_folder = './labels'
    
    # 执行转换
    convert_folder(input_folder, output_folder)
    print("Conversion completed!")
