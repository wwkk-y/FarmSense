```shell
python train.py --img 640 --batch 16 --epochs 64 --data D:\work-wyz\yolov5-pro\number\config.yaml --weights yolov5s.pt --nosave --cache --project D:\work-wyz\yolov5-pro\number\train_output\
```

```shell
python detect.py --weights D:\work-wyz\yolov5-pro\number\train_output\exp\weights\best.pt --img 640 --conf 0.25 --source D:\work-wyz\yolov5-pro\number\test\ --project D:\work-wyz\yolov5-pro\number\test_output\
```