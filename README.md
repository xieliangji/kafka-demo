## Kafka quickstart

> **Download & Install**
> > [Click for downloading Kafka-2.13-3.5.0](https://dlcdn.apache.org/kafka/3.5.0/kafka_2.13-3.5.0.tgz)
>
> > `tar -xzf kafka_2.13-3.5.0.tgz`
>
> > `cd kafka_2.13-3.5.0`
>
> **Setup**
> > **setup zookeeper**
> >> `$ bin/zookeeper-server-start.sh config/zookeeper.properties`
> >
> > **setup kafka**
> >> `$ bin/kafka-server-start.sh config/server.properties`
>
> **Create A Topic**
> > `$ bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092`
>
> **Write Events To Topic**
> > `$ bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092`
> >> `> this is first event`
> >>
> >> `> this is second event`
> >>
> >> `> Ctrl+C` # stop producer client
>
> **Read Events From Topic**
> > `$ bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092`
> >> `this is first event`
> >>
> >> `this is second event`
> >
> `Ctrl+C` # stop consumer client
---

## Springboot + Kafka

> **Dependencies**
>
> [click pom.xml for lookup](pom.xml)
---
