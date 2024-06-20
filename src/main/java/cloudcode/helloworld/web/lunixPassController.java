package cloudcode.helloworld.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/** Defines a controller to handle HTTP requests */
@Controller
public final class lunixPassController {

  private static String project;
  private static final Logger logger = LoggerFactory.getLogger(lunixPassController.class);

  @GetMapping("/")
  public String helloWorld(Model model) {
    String revision = System.getenv("K_REVISION") == null ? "???" : System.getenv("K_REVISION");
    String service = System.getenv("K_SERVICE") == null ? "???" : System.getenv("K_SERVICE");

    model.addAttribute("revision", revision);
    model.addAttribute("service", service);
    return "index";
  }

  private static final String TEST_EMAIL = "sain@mail.com";
  private static final String TEST_PASS = "123";

  @GetMapping("/login")
  public String showLoginForm() {
    return "login";
  }

  @PostMapping("/login")
  public String login(@RequestParam("email") String email,
                      @RequestParam("password") String password,
                      Model model) {
    if (TEST_EMAIL.equals(email) && TEST_PASS.equals(password)) {
      return "admin";
    } else {
      model.addAttribute("error", "Invalid email or password");
      return "login";
    }
  }

  @GetMapping("/register")
  public String showRegisterForm() {
    return "register";
  }

  @GetMapping("/homepage")
  public String showHomepage() {
    return "homepage";

  }
  @GetMapping("/admin")
  public String dashboard(Model model) {
    return "dashboard";
  }
  @GetMapping("/admin/user")
  public String userTable(Model model) {
    return "user";
  }
 @GetMapping("/admin/game")
  public String gameTable(Model model) {
   return "game";
 }
 @GetMapping("/admin/news")
  public String newsTable(Model model) {
   return "news";
 }
}
