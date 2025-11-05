# Arabic Pluralization Guide

## Overview
Arabic has complex plural rules that differ significantly from English. The timeago library implements these rules using Java's `MessageFormat` choice patterns.

## Arabic Plural Forms

| Range | Form | Example | Notes |
|-------|------|---------|-------|
| 1 | Singular | دقيقة (daqīqa) | Single item |
| 2 | Dual | دقيقتين (daqīqatayn) | Exactly two items, uses special ending |
| 3+ | Plural | دقائق (daqā'iq) | Three or more items |

## Implementation

We use MessageFormat choice syntax:
```
{0,choice,1#singular|2#dual|2<plural}
```

- `1#` - Equals exactly 1
- `2#` - Equals exactly 2  
- `2<` - Greater than 2

## Examples

- "منذ دقيقة" (1 minute ago) - singular
- "منذ 2 دقيقتين" (2 minutes ago) - dual form
- "منذ 5 دقائق" (5 minutes ago) - plural form
- "منذ 25 دقائق" (25 minutes ago) - plural form (>10 also uses plural)

## Testing

All edge cases are covered:
- ✓ Singular (1)
- ✓ Dual (2)
- ✓ Plural (3-10)
- ✓ Large numbers (>10)
- ✓ Zero handling

## Maintainer Notes

When adding new time units in Arabic:
1. Always provide all three forms: singular, dual, plural
2. Use the choice pattern format above
3. Test with values 0, 1, 2, 3, 10, 11, 100