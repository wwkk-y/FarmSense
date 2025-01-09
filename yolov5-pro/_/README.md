```shell
python ../../yolov5/train.py ^
  --img 640 --batch 32 --epochs 64 ^
  --data ./config.yaml ^
  --weights yolov5s.pt ^
  --nosave --cache ^
  --project ./train_output/
```

```shell
python ../../yolov5/detect.py ^
  --weights ./train_output/exp/weights/best.pt ^
  --img 640 --conf 0.5 ^
  --source ./test/ ^
  --project ./test_output/
```

--- 

```shell
python train.py \
  --img 640 --batch 32 --epochs 64 \
  --data ../yolov5-pro/project/config.yaml \
  --weights yolov5s.pt \
  --nosave --cache \
  --project ../yolov5-pro/project/train_output/
```

```shell
python detect.py \
  --weights ../yolov5-pro/project/train_output/exp/weights/last.pt \
  --img 640 --conf 0.5 \
  --source ../yolov5-pro/project/test/ \
  --project ../yolov5-pro/project/test_output/
```