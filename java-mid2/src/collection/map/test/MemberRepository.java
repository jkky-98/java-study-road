package collection.map.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class  MemberRepository  {
    Map<String, Member> map = new HashMap<>();

    public void save(Member member) {
        map.put(member.getId(), member);
    }

    public Member findById(String id) {
        return map.get(id);
    }

    public Member findByName(String name) {
        for (Member value : map.values()) {
            if (value.getName().equals(name)) {
                return value;
            }
        }
        return null;
    }

    public Member remove(String id) {
        return map.remove(id);
    }
}
