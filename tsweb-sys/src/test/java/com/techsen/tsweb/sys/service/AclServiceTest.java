package com.techsen.tsweb.sys.service;

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
public class AclServiceTest {

    @Resource
    private AclService aclService;
    
    private Acl acl;
    
    @Before
    public void init() {
        this.acl = new Acl().setPrincipalName("U1")
                .setPrincipalType(PrincipalType.User).setResourceName("M1")
                .setResourceType(ResourceType.Menu).setAclCode(0x01);

        this.aclService.addAcl(this.acl);
    }
    
    @After
    public void clear() {
        this.aclService.deleteAcl(this.acl);
    }
    
    @Test
    public void testUpdateAcl() {
        Acl tmp = this.aclService.getAcl(this.acl);
        Assert.assertNotNull(tmp);
        Assert.assertNotNull(tmp.getId());
        Assert.assertNotNull(tmp.getCreateDate());
        Assert.assertEquals(this.acl.getId(), tmp.getId());
        Assert.assertEquals(this.acl.getPrincipalName(), tmp.getPrincipalName());
        Assert.assertEquals(this.acl.getPrincipalType(), tmp.getPrincipalType());
        Assert.assertEquals(this.acl.getResourceName(), tmp.getResourceName());
        Assert.assertEquals(this.acl.getResourceType(), tmp.getResourceType());
        Assert.assertEquals(this.acl.getAclCode(), tmp.getAclCode());

        tmp.setPrincipalName("R1").setPrincipalType(PrincipalType.Role)
                .setResourceName("C1").setResourceType(ResourceType.Controller);
        this.aclService.updateAcl(tmp);
        
        Acl tmp2 = this.aclService.getAcl(tmp);
        Assert.assertNotNull(tmp2);
        Assert.assertNotNull(tmp2.getUpdateDate());
        Assert.assertEquals(tmp.getId(), tmp2.getId());
        Assert.assertEquals(tmp.getPrincipalName(), tmp2.getPrincipalName());
        Assert.assertEquals(tmp.getPrincipalType(), tmp2.getPrincipalType());
        Assert.assertEquals(tmp.getResourceName(), tmp2.getResourceName());
        Assert.assertEquals(tmp.getResourceType(), tmp2.getResourceType());
        Assert.assertEquals(tmp.getAclCode(), tmp2.getAclCode());
    }
}
