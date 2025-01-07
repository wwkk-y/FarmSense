```shell
python train.py ^
  --img 640 --batch 32 --epochs 64 ^
  --data todo_set_path/config.yaml ^
  --weights yolov5s.pt ^
  --nosave --cache ^
  --project todo_set_path/train_output/
```

```shell
python detect.py ^
  --weights todo_set_path/train_output/exp/weights/best.pt ^
  --img 640 --conf 0.5 ^
  --source todo_set_path/test/ ^
  --project todo_set_path/test_output/
```