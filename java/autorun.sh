mvn compile
rm ./file.txt

echo "" >> file.txt
echo "Test for 10 elements and batch of 1000" >> file.txt
rm contacts.sqlite3 && mvn -q exec:java -D exec.args="10 1000" >> file.txt

echo "" >> file.txt
echo "Test for 100 elements and batch of 1000" >> file.txt
rm contacts.sqlite3 && mvn -q exec:java -D exec.args="100 1000" >> file.txt

echo "" >> file.txt
echo "Test for 1000 elements and batch of 1000" >> file.txt
rm contacts.sqlite3 && mvn -q exec:java -D exec.args="1000 1000" >> file.txt

echo "" >> file.txt
echo "Test for 10000 elements and batch of 1000" >> file.txt
rm contacts.sqlite3 && mvn -q exec:java -D exec.args="10000 1000" >> file.txt

echo "" >> file.txt
echo "Test for 50_000 elements and batch of 1000" >> file.txt
rm contacts.sqlite3 && mvn -q exec:java -D exec.args="50000 1000" >> file.txt

echo "" >> file.txt
echo "Test for 100_000 elements and batch of 1000" >> file.txt
rm contacts.sqlite3 && mvn -q exec:java -D exec.args="100000 1000" >> file.txt

echo "" >> file.txt
echo "Test for 1_000_000 elements and batch of 1000" >> file.txt
rm contacts.sqlite3 && mvn -q exec:java -D exec.args="1000000 1000" >> file.txt

################################################################

echo "" >> file.txt
echo "Test for 10 elements and batch of 500" >> file.txt
rm contacts.sqlite3 && mvn -q exec:java -D exec.args="10 500" >> file.txt

echo "" >> file.txt
echo "Test for 100 elements and batch of 500" >> file.txt
rm contacts.sqlite3 && mvn -q exec:java -D exec.args="100 500" >> file.txt

echo "" >> file.txt
echo "Test for 1000 elements and batch of 500" >> file.txt
rm contacts.sqlite3 && mvn -q exec:java -D exec.args="1000 500" >> file.txt

echo "" >> file.txt
echo "Test for 10000 elements and batch of 500" >> file.txt
rm contacts.sqlite3 && mvn -q exec:java -D exec.args="10000 500" >> file.txt

echo "" >> file.txt
echo "Test for 50_000 elements and batch of 500" >> file.txt
rm contacts.sqlite3 && mvn -q exec:java -D exec.args="50000 500" >> file.txt

echo "" >> file.txt
echo "Test for 100_000 elements and batch of 500" >> file.txt
rm contacts.sqlite3 && mvn -q exec:java -D exec.args="100000 500" >> file.txt

echo "" >> file.txt
echo "Test for 1_000_000 elements and batch of 500" >> file.txt
rm contacts.sqlite3 && mvn -q exec:java -D exec.args="1000000 500" >> file.txt