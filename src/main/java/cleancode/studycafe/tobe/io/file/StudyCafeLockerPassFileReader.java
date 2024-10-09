package cleancode.studycafe.tobe.io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafePassType;

public class StudyCafeLockerPassFileReader implements FileReader<StudyCafeLockerPass> {

    public final static String LOCKER_FILE_PATH = "src/main/resources/cleancode/studycafe/pass-list.csv";

    @Override
    public List<StudyCafeLockerPass> read() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(LOCKER_FILE_PATH));
            List<StudyCafeLockerPass> lockerPasses = new ArrayList<>();
            for (String line : lines) {
                String[] values = line.split(",");
                StudyCafePassType passType = StudyCafePassType.valueOf(values[0]);
                int duration = Integer.parseInt(values[1]);
                int price = Integer.parseInt(values[2]);

                lockerPasses.add(StudyCafeLockerPass.of(passType, duration, price));
            }
            return lockerPasses;
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는 중 오류가 발생했습니다.", e);
        }
    }
}