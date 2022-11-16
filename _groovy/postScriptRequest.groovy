import static org.camunda.spin.Spin.*;
import org.camunda.spin.json.*;

SpinJsonNode json = JSON("{}");
json = json.prop("name", name);
json = json.prop("job", "Consultant");
String req = json.toString();
println req;
return req;



