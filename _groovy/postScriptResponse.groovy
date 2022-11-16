import static org.camunda.spin.Spin.*
import org.camunda.spin.json.*

println response
SpinJsonNode json = JSON(response)
String id = json.prop("id").stringValue()
println id
return id