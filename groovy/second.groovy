@Grab(group='org.yaml', module='snakeyaml', version='1.5')
import org.yaml.snakeyaml.*
//def yaml = new Yaml()
//def document = "\n- Hesperiidae\n- Papilionidae\n- Apatelodidae\n- Epiplemidae"
//list = (List<String>) yaml.load(document)
//println(list)

Yaml yaml = new Yaml()
def obj = yaml.load("""
a: 1
b: 2
c:
- aaa
- bbb""")

assert obj.a == 1
assert obj.b == 2
assert obj.c == ["aaa", "bbb"]
println(obj)

return ;
