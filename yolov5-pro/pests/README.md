```shell
python train.py \
  --img 320 --batch 128 --epochs 500 \
  --data ../yolov5-pro/pests/config.yaml \
  --weights yolov5s.pt \
  --cache \
  --project ../yolov5-pro/pests/train_output/
```

```shell
python detect.py \
  --weights ../yolov5-pro/pests/train_output/exp/weights/best.pt \
  --img 320 --conf 0.5 \
  --source ../yolov5-pro/pests/test/ \
  --project ../yolov5-pro/pests/test_output/
```

```shell
python ../../yolov5/detect.py ^
  --weights ./train_output/exp/weights/last.pt ^
  --img 320 --conf 0.5 ^
  --source ./test/ ^
  --project ./test_output/
```

30 及之前 结果 = 号+1
31 及之后 结果 = 号