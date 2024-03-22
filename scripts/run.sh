#!/bin/bash

# Get the current directory of the script
CURRENT_DIR=$(dirname "${BASH_SOURCE[0]}")

# Navigate to the script's directory
cd "$CURRENT_DIR" || exit

# Go one directory up to the project root
cd ..

# Create a directory for compiled files if it doesn't exist
mkdir -p compiled

javac -d ./compiled/ \
./src/Main.java \
./src/Utils.java \
./src/Game/Cursor.java \
./src/Game/Game.java \
./src/Game/Grid.java \
./src/Game/Vector2.java \
./src/Models/Lawnmower.java \
./src/Models/Model.java \
./src/Models/Projectile.java \
./src/Models/Sun.java \
./src/Models/Plants/Cherrybomb.java \
./src/Models/Plants/Peashooter.java \
./src/Models/Plants/Plant.java \
./src/Models/Plants/Sunflower.java \
./src/Models/Plants/Wallnut.java \
./src/Models/Zombies/Zombie.java

java -cp compiled Main