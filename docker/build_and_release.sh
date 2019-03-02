#!/bin/bash
IMAGE_LABEL=sergioarroutbibraojos
for dir in $(find . -type d); 
do
  pushd $dir
  image=$(basename $(pwd))
  docker build -t=${image} .
  docker tag ${image}:latest sarroutbi/${image}:${IMAGE_LABEL}
  docker push sarroutbi/${image}:${IMAGE_LABEL}
  popd
done 
