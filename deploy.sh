#!/bin/bash

PORT=8080
eval $(sed 's/^web://' Procfile)
