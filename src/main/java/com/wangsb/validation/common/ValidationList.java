package com.wangsb.validation.common;

import lombok.Data;
import lombok.experimental.Delegate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangshenbing
 */
@Data
public class ValidationList<E> implements List<E> {
    @Valid
    @Delegate
    private List<E> list = new ArrayList<>();
}