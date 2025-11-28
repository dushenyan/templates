import type {ComplexBookView_TargetOf_authors, ComplexBookView_TargetOf_store} from './';

/**
 * Complex Book DTO defined by DTO Language
 */
export interface ComplexBookView {
    /**
     * The surrogate id of the current object,
     * auto-incrementing,
     * without specific business meaning
     */
    readonly id: number;
    /**
     * The name of current Book.
     * 
     * <p>This property forms a unique constraint together with
     * the {@code edition} property, which is {@code @Key} of Jimmer</p>
     */
    readonly name: string;
    /**
     * The edition of current Book.
     * 
     * <p>This property forms a unique constraint together with
     * the {@code name} property, which is {@code @Key} of Jimmer</p>
     */
    readonly edition: number;
    readonly price: number;
    /**
     * The bookstore to which the current book belongs,
     * representing a many-to-one association
     */
    readonly store?: ComplexBookView_TargetOf_store | undefined;
    /**
     * All authors who participated in writing
     * the current book,
     * representing a many-to-many association
     */
    readonly authors: ReadonlyArray<ComplexBookView_TargetOf_authors>;
}
