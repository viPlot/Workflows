package JPAHibernate.service.ui;

import JPAHibernate.AppException;
import JPAHibernate.service.dao.BranchService;
import JPAHibernate.service.locale.LocaleService;
import JPAHibernate.service.dao.domain.Branch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;

import java.util.Collection;

import static java.util.stream.Collectors.joining;

@ShellComponent
@RequiredArgsConstructor
public class Commands {
    private final BranchService branchService;
    private final IOService ioService;
    private final LocaleService localeService;

    public enum State {
        EXISTING_COMMANDS("Existing commands"), PROCESSING_BRANCH("branch processing");
        @Getter
        private final String title;

        State(String title) {
            this.title = title;
        }
    }

    @Getter
    private State state = State.EXISTING_COMMANDS;

    private Branch handlingBrunch;

    @ShellMethod(value = "find all branches", key = "find-all")
    @ShellMethodAvailability("availableExistingCommands")
    public void showAllBranches() {
        var branches = branchService.findAll();
        if (branches.isEmpty())
            ioService.interPrintln("no-branch-found");
        else
            ioService.println(branchesToString(branches));
    }

    @ShellMethod(value = "find branch by city", key = "find-by-id")
    @ShellMethodAvailability("availableExistingCommands")
    public void findBranchByCity(@ShellOption(defaultValue = "") String city) {
        if (city.isEmpty()) {
            ioService.interPrint("print-id");
            city = ioService.readLine();
        }
        if (city.isBlank())
            ioService.interPrint("operation-cancelled-by-empty-line");
        else {
            var branches = branchService.findByCity(city);
            if (city.isEmpty())
                ioService.interPrintln("no-branch-found");
            else
                ioService.println(branchesToString(branches));
        }
    }

    @ShellMethod(value = "insert branch", key = "insert")
    @ShellMethodAvailability("availableExistingCommands")
    public void insertBranch() {
        handlingBrunch = new Branch(0, "", 0, 0, "");
        state = State.PROCESSING_BRANCH;
        ioService.println(branchToString(handlingBrunch));
    }

    @ShellMethod(value = "update branch", key = "update")
    @ShellMethodAvailability("availableExistingCommands")
    public void updateBranch(@ShellOption(defaultValue = "") String city) {
        if (city.isEmpty()) {
            ioService.interPrint("print-city");
            city = ioService.readLine();
        }
        if (city.isBlank())
            ioService.interPrintln("operation-cancelled-by-empty-line");
        else {
            var branches = branchService.findByCity(city);
            if (branches.isEmpty())
                ioService.interPrintln("no-branch-found");
            else if (branches.size() > 1) {
                ioService.interPrintln("too-many-branch-found");
                ioService.println(branchesToString(branches));
            }
            else handlingBrunch = branches.iterator().next();
            state = State.PROCESSING_BRANCH;
            ioService.println(branchToString(handlingBrunch));
        }
    }

    @ShellMethod(value = "change current language", key = {"language", "lang"})
    @ShellMethodAvailability("availableExistingCommands")
    public void setLanguage(String lang) {
        try {
            localeService.set(lang.strip().toLowerCase());
        }
        catch (AppException e) {
            ioService.interPrintln(e.getMessage(), e.getParams());
        }
    }

    private Availability availableExistingCommands() {
        return state == State.EXISTING_COMMANDS ? Availability.available()
                : Availability.unavailable(("available in " + State.PROCESSING_BRANCH.getTitle() +
                "only, you now in " + state.getTitle()));
    }

    private String branchesToString(Collection<Branch> branches) {
        return branches.stream()
                .map(this::branchToString)
                .collect(joining("<--------------------->\n"));
    }

    private String branchToString(Branch branch) {
        var empty = "<" + ioService.inter("branch empty" + ">");
        var city = branch.getCity().isBlank() ? empty : branch.getCity();
        var index = branch.getIndex() == 0 ? empty : Integer.toString(branch.getIndex());
        var number  = branch.getNumber() == 0 ? empty : Integer.toString(branch.getNumber());
        var address = branch.getAddress().isBlank() ? empty : branch.getAddress();

        return ioService.inter("branch.city") + ": " + city + "\n" +
                ioService.inter("branch.index") + ": " + index + "\n" +
                ioService.inter("branch.number") + ": " + number + "\n" +
                ioService.inter("branch.address") + ": " + address + "\n";
    }
}