package com.techsen.tsweb.core.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techsen.tsweb.core.domain.BaseEntity;

public class ObjectUtilTest {
    A a = new A();
    
    @Before
    public void init() {
        this.a.name = "hayden";
        this.a.age = 25;
    }
    
    @Test
    public void testGetGenericType() {
        Assert.assertEquals(A.class, ObjectUtil.getGenericType(this.a));;
    }
    
    @Test
    public void testClone() {
        A b = ObjectUtil.clone(a);
        Assert.assertEquals(this.a.getId(), b.getId());;
        Assert.assertEquals(this.a.name, b.name);
        Assert.assertEquals(this.a.age, b.age);
    }
}

@SuppressWarnings("serial")
class A extends BaseEntity<A> {
    String name;
    int age;
}
