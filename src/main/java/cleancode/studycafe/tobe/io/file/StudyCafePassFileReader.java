package cleancode.studycafe.tobe.io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import cleancode.studycafe.tobe.model.StudyCafePass;
import cleancode.studycafe.tobe.model.StudyCafePassType;

public class StudyCafePassFileReader implements FileReader<StudyCafePass> {

    private final String PASS_FILE_PATH = "src/main/resources/cleancode/studycafe/pass-list.csv";

    @Override
    public List<StudyCafePass> read() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(PASS_FILE_PATH));
            List<StudyCafePass> studyCafePasses = new ArrayList<>();
            for (String line : lines) {
                String[] values = line.split(",");
                StudyCafePassType passType = StudyCafePassType.valueOf(values[0]);
                int duration = Integer.parseInt(values[1]);
                int price = Integer.parseInt(values[2]);
                double discountRate = Double.parseDouble(values[3]);

                studyCafePasses.add(StudyCafePass.of(passType, duration, price, discountRate));
            }
            return studyCafePasses;
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는 중 오류가 발생했습니다.", e);
        }
    }
}