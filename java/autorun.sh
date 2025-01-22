#!/bin/bash
mvn compile
rm -f ./file.txt

declare -a elements=("10" "100" "1000" "10000" "50000" "100000" "1000000")
declare -a batches=("1000" "500")

for batch in "${batches[@]}"; do
    for element in "${elements[@]}"; do
        echo "" >> file.txt
        echo "Test for ${element} elements and batch of ${batch}" >> file.txt
        rm -f contacts.sqlite3
        mvn -q exec:java -D exec.args="${element} ${batch}" >> file.txt
    done
done
