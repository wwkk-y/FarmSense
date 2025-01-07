```shell
python train.py --img 320 --batch 128 --epochs 64 --data D:\work-wyz\FarmSense\yolov5-test\config.yaml --weights yolov5s.pt --nosave --cache --project D:\work-wyz\FarmSense\yolov5-test\train_output\
```

```shell
python detect.py --weights D:\work-wyz\FarmSense\yolov5-test\train_output\exp\weights\best.pt --img 320 --conf 0.5 --source D:\work-wyz\FarmSense\yolov5-test\test\ --project D:\work-wyz\FarmSense\yolov5-test\test_output\
```