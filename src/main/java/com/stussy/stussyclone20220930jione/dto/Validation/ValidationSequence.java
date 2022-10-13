package com.stussy.stussyclone20220930jione.dto.Validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({ValidationGroups.NotBlankGroup.class,
        ValidationGroups.SizeGroup.class,
        ValidationGroups.PatternGroup.class,
        Default.class
})
public interface ValidationSequence {
}
