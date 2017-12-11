#!/bin/bash
gcc -c QueueImplementation.c
gcc -c QueueDriver.c
gcc -o QueueDriver QueueImplementation.o  QueueDriver.o
