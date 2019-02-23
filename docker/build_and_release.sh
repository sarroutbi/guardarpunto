#!/bin/bash
for dir in $(find . -type d); 
do
  pushd $dir
  image=$(basename $(pwd))
  docker build -t=${image} .
  docker tag ${image}:latest sarroutbi/${image}:latest
  docker push sarroutbi/${image}:latest
  popd
done 
