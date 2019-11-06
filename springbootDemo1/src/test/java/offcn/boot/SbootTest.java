package offcn.boot;

import com.offcn.HelloApplication;
import com.offcn.mapper.UserMapper;
import com.offcn.pojo.MUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloApplication.class)
public class SbootTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void getUserList(){
        List<MUser> userList=userMapper.getUserList();
        for (MUser user:userList){
            System.out.println(user);
        }
    }
    @Test
    public void getRedis(){
        redisTemplate.opsForValue().set("java","我爱java");
        String str =(String) redisTemplate.opsForValue().get("java");
        System.out.println(str);
        MUser mUser=new MUser();
        mUser.setId(1);
        mUser.setName("aa");
        redisTemplate.opsForValue().set("user",mUser);
        MUser user =(MUser) redisTemplate.opsForValue().get("user");
        System.out.println(user);
    }
}
