## 创建和删除 `Topic`
> 创建
```bash
$ bin/kafka-topics.sh --bootstrap-server $BROKER_HOST:$PORT --create --topic new_topic_name \
 --partitions 5 --replication-factor 3 --config x=y
```
> 删除
```bash
$ bin/kafka-topics.sh --bootstrap-server $BROKER_HOST:$PORT --delete --topic new_topic_name
```
---
