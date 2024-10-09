package cleancode.studycafe.tobe.io;

import java.util.List;

import cleancode.studycafe.tobe.model.StudyCafePass;
import cleancode.studycafe.tobe.model.StudyCafePassType;

public class PassSelector {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public OutputHandler getOutputHandler() {
        return outputHandler;
    }

    public PassSelector(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public StudyCafePass selectPass(List<StudyCafePass> studyCafePasses, StudyCafePassType passType) {
        List<StudyCafePass> filteredPasses = studyCafePasses.stream()
                .filter(pass -> pass.getPassType() == passType)
                .toList();

        outputHandler.showPassListForSelection(filteredPasses);
        return inputHandler.getSelectPass(filteredPasses);
    }

}
