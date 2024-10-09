package cleancode.studycafe.tobe;

import java.util.List;
import java.util.Optional;

import cleancode.studycafe.tobe.config.StudyCafeConfig;
import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.io.InputHandler;
import cleancode.studycafe.tobe.io.OutputHandler;
import cleancode.studycafe.tobe.io.PassSelector;
import cleancode.studycafe.tobe.io.file.FileReader;
import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafePass;
import cleancode.studycafe.tobe.model.StudyCafePassType;

public class StudyCafePassMachine {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final PassSelector passSelector;
    private final FileReader<StudyCafePass> passFileReader;
    private final FileReader<StudyCafeLockerPass> lockerPassFileReader;

    public StudyCafePassMachine(StudyCafeConfig config) {
        this.inputHandler = config.getInputHandler();
        this.outputHandler = config.getOutputHandler();
        this.passSelector = config.getPassSelector();
        this.passFileReader = config.getPassFileReader();
        this.lockerPassFileReader = config.getLockerPassFileReader();
    }

    public void run() {
        try {
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();
            StudyCafePassType passType = getPassType();
            StudyCafePass selectedPass = selectPass(passType);
            StudyCafeLockerPass lockerPass = getLockerPassIfRequired(selectedPass, passType);
            outputHandler.showPassOrderSummary(selectedPass, lockerPass);
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private StudyCafePassType getPassType() {
        outputHandler.askPassTypeSelection();
        return inputHandler.getPassTypeSelectingUserAction();
    }

    private StudyCafePass selectPass(StudyCafePassType passType) {
        List<StudyCafePass> passes = passFileReader.read();
        return passSelector.selectPass(passes, passType);
    }

    private StudyCafeLockerPass getLockerPassIfRequired(StudyCafePass selectedPass, StudyCafePassType passType) {
        if (passType == StudyCafePassType.FIXED) {
            List<StudyCafeLockerPass> lockerPasses = lockerPassFileReader.read();
            return lockerPasses.stream()
                    .filter(lockerPass -> lockerPass.isSelectedLockerPass(selectedPass))
                    .findFirst()
                    .flatMap(lockerPass -> {
                        outputHandler.askLockerPass(lockerPass);
                        return doesUserSelectLocker() ? Optional.of(lockerPass) : Optional.empty();
                    })
                    .orElse(null);

        }
        return null;
    }

    private boolean doesUserSelectLocker() {
        return inputHandler.getLockerSelection();
    }
}