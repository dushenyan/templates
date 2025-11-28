/**
 * Simple Book DTO defined by DTO Language
 */
export interface SimpleBookView {
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
}
