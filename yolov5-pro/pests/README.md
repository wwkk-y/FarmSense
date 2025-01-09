```shell
python ../../yolov5/train.py ^
  --img 320 --batch 32 --epochs 64 ^
  --data ./config.yaml ^
  --weights yolov5s.pt ^
  --nosave --cache ^
  --project ./train_output/
```

```shell
python ../../yolov5/detect.py ^
  --weights ./train_output/exp/weights/last.pt ^
  --img 320 --conf 0.5 ^
  --source ./test/ ^
  --project ./test_output/
```

---

```shell
python train.py \
  --img 320 --batch 32 --epochs 64 \
  --data ../yolov5-pro/pests/config.yaml \
  --weights yolov5s.pt \
  --nosave --cache \
  --project ../yolov5-pro/pests/train_output/
```

```shell
python detect.py \
  --weights ../yolov5-pro/pests-test/train_output/exp/weights/last.pt \
  --img 320 --conf 0.5 \
  --source ../yolov5-pro/pests-test/test/ \
  --project ../yolov5-pro/pests-test/test_output/
```