package org.apache.activemq.ide;

public class Bootstrap {
    // just run with these application parameters: start xbean:file:activemq.xml
    // -Xms64M -Xmx1G -Djava.util.logging.config.file=logging.properties -Djava.security.auth.login.config=/Users/bgu/Downloads/apache-activemq-5.14.5//conf/login.config -Dcom.sun.management.jmxremote -Djava.awt.headless=true -Djava.io.tmpdir=/Users/bgu/Downloads/apache-activemq-5.14.5//tmp -Dactivemq.classpath=/Users/bgu/Downloads/apache-activemq-5.14.5//conf:/Users/bgu/Downloads/apache-activemq-5.14.5//../lib/: -Dactivemq.home=/Users/bgu/Downloads/apache-activemq-5.14.5/ -Dactivemq.base=/Users/bgu/Downloads/apache-activemq-5.14.5/ -Dactivemq.conf=/Users/bgu/Downloads/apache-activemq-5.14.5//conf -Dactivemq.data=/Users/bgu/Downloads/apache-activemq-5.14.5//data
    public static void main(String[] args) {
        org.apache.activemq.console.Main.main(args);
    }
}
