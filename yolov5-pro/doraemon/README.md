```shell
python train.py ^
  --img 640 --batch 32 --epochs 64 ^
  --data D:\work-wyz\FarmSense\yolov5-pro\_doraemon\config.yaml ^
  --weights yolov5s.pt ^
  --nosave --cache ^
  --project D:\work-wyz\FarmSense\yolov5-pro\_doraemon\train_output\
```

```shell
python detect.py ^
  --weights D:\work-wyz\FarmSense\yolov5-pro\_doraemon\train_output\exp\weights\best.pt ^
  --img 640 --conf 0.5 ^
  --source D:\work-wyz\FarmSense\yolov5-pro\_doraemon\test\ ^
  --project D:\work-wyz\FarmSense\yolov5-pro\_doraemon\test_output\
```