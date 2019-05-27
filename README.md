PREREQUISITE:

* npm >= 3.0.0
* node >= 6.0.0
* java >= 8
* maven >= 3.5.2

Add jdk and maven to PATH variable.

Install blockchain-wallet-service:

```
sudo npm install -g blockchain-wallet-service
```

Once it's finished, run following command:

```
blockchain-wallet-service start
```

and let it work in the background.

Preferable way of running my tests is to open this project in IntelliJ IDEA then open file src/test/resources/testng.xml and press CTRL + SHIFT + F10.

Another way is to run following command in a terminal:

```
mvn clean install
```
