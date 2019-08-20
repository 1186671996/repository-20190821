import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kgc.mapper.UserMapper;
import com.kgc.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class Test
{
    private Logger logger = Logger.getLogger(Test.class);
    @Resource
    UserMapper userMapper;
    @Resource
    private UserService userService;
    
    @org.junit.Test
    public void selectAll()
    {
        System.out.println(userMapper.selectAll(null));
    }
}
