<template>
    <div id="home">
        <h2>欢迎使用FarmSense</h2>
        <div style="margin-top: 20px;">
            <!-- 预览框 -->
            <el-row>
                <div class="preview-box">
                    <img :src="previewImage" alt="预览图片" class="preview-image" />
                </div>
                <div class="preview-box">
                    <img :src="caseImage" alt="结果图片" class="preview-image" />
                </div>
            </el-row>



            <el-row>
                <!-- 图片上传框 -->
                <el-upload action="#" :auto-upload="false" :on-change="handleFileChange" :show-file-list="false"
                    accept="image/*" class="upload-box">
                    <el-button type="primary">选择图片</el-button>
                </el-upload>

                <!-- 上传按钮 -->
                <el-button type="success" :disabled="!selectedFile" @click="uploadImage" style="margin-top: 10px;">
                    上传图片
                </el-button>
            </el-row>

        </div>
    </div>
</template>

<script setup>
import { ref } from "vue";
import { ElMessage } from "element-plus";

const selectedFile = ref(null); // 存储选中的文件
const previewImage = ref(``); // 存储预览图片的 URL
const caseImage = ref(``)

// 文件选择回调
const handleFileChange = (file) => {
    selectedFile.value = file.raw; // 获取文件对象
    previewImage.value = URL.createObjectURL(file.raw); // 创建预览图片 URL
};

// 上传图片
const uploadImage = async () => {
    if (!selectedFile.value) {
        ElMessage.error("请先选择一张图片！");
        return;
    }

    const formData = new FormData();
    formData.append("file", selectedFile.value);

    try {
        const response = await fetch("http://1.15.232.25:699/upload", {
            method: "POST",
            body: formData,
        });

        if (!response.ok) {
            throw new Error("上传失败");
        }

        // 假设服务器返回的是二进制图片数据
        const blob = await response.blob(); // 获取返回的 Blob 数据
        caseImage.value = URL.createObjectURL(blob); // 将 Blob 转换为图片 URL
        ElMessage.success("上传成功！");
    } catch (error) {
        ElMessage.error("上传失败：" + error.message);
    }
};

</script>

<style scoped>
.upload-box {
    margin-top: 10px;
    margin-right: 10px;
}

.preview-box {
    width: 400px;
    height: 300px;
    border: 1px dashed #ccc;
    display: flex;
    justify-content: center;
    align-items: center;
    overflow: hidden;
}

.preview-image {
    max-width: 100%;
    max-height: 100%;
}
</style>