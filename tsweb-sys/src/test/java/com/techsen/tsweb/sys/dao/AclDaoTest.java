package com.techsen.tsweb.sys.dao;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.sys.domain.Acl;
import com.techsen.tsweb.sys.domain.PrincipalType;
import com.techsen.tsweb.sys.domain.ResourceType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class AclDaoTest {

    @Resource
    private AclDao aclDao;

    private Acl acl;

    @Before
    public void init() {
        this.acl = new Acl().setId("ACL0").setPrincipalName("U1")
                .setPrincipalType(PrincipalType.User).setResourceName("M1")
                .setResourceType(ResourceType.Menu).setAclCode(0x01);

        this.aclDao.addEntity(this.acl);
    }

    @After
    public void clear() {
        this.aclDao.deleteEntity(this.acl);
    }

    @Test
    public void testUpdateAcl() {
        Acl tmp = this.aclDao.getEntity(this.acl);
        Assert.assertNotNull(tmp);
        Assert.assertEquals(this.acl.getId(), tmp.getId());
        Assert.assertEquals(this.acl.getPrincipalName(), tmp.getPrincipalName());
        Assert.assertEquals(this.acl.getPrincipalType(), tmp.getPrincipalType());
        Assert.assertEquals(this.acl.getResourceName(), tmp.getResourceName());
        Assert.assertEquals(this.acl.getResourceType(), tmp.getResourceType());
        Assert.assertEquals(this.acl.getAclCode(), tmp.getAclCode());

        tmp.setPrincipalName("R1").setPrincipalType(PrincipalType.Role)
                .setResourceName("C1").setResourceType(ResourceType.Controller);
        this.aclDao.updateEntity(tmp);
        
        Acl tmp2 = this.aclDao.getEntity(tmp);
        Assert.assertNotNull(tmp2);
        Assert.assertEquals(tmp.getId(), tmp2.getId());
        Assert.assertEquals(tmp.getPrincipalName(), tmp2.getPrincipalName());
        Assert.assertEquals(tmp.getPrincipalType(), tmp2.getPrincipalType());
        Assert.assertEquals(tmp.getResourceName(), tmp2.getResourceName());
        Assert.assertEquals(tmp.getResourceType(), tmp2.getResourceType());
        Assert.assertEquals(tmp.getAclCode(), tmp2.getAclCode());
    }

}
