import type {Gender} from '../enums/';

export interface ComplexBookView_TargetOf_authors {
    /**
     * The surrogate id of the current object,
     * auto-incrementing,
     * without specific business meaning
     */
    readonly id: number;
    /**
     * The first name of current Author.
     * 
     * <p>This property forms a unique constraint together with
     * the {@code lastName} property, which is {@code @Key} of Jimmer</p>
     */
    readonly firstName: string;
    /**
     * The last name of current Book.
     * 
     * <p>This property forms a unique constraint together with
     * the {@code firstName} property, which is {@code @Key} of Jimmer</p>
     */
    readonly lastName: string;
    readonly gender: Gender;
}
