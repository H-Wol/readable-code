package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.config.StudyCafeConfig;
import cleancode.studycafe.tobe.io.ConsoleInputHandler;
import cleancode.studycafe.tobe.io.ConsoleOutputHandler;
import cleancode.studycafe.tobe.io.PassSelector;
import cleancode.studycafe.tobe.io.file.StudyCafeLockerPassFileReader;
import cleancode.studycafe.tobe.io.file.StudyCafePassFileReader;

public class StudyCafeApplication {

    public static void main(String[] args) {

        StudyCafeConfig config = new StudyCafeConfig(
                new PassSelector(new ConsoleInputHandler(), new ConsoleOutputHandler()),
                new StudyCafePassFileReader(),
                new StudyCafeLockerPassFileReader());

        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(config);
        studyCafePassMachine.run();
    }
}