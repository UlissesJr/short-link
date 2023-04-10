package top.luobogan.service.impl;

import top.luobogan.model.AccountDO;
import top.luobogan.mapper.AccountMapper;
import top.luobogan.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Luobogan
 * @since 2023-04-10
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, AccountDO> implements AccountService {

}
