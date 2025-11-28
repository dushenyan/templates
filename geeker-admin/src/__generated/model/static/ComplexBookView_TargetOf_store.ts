export interface ComplexBookView_TargetOf_store {
    /**
     * The surrogate id of the current object,
     * auto-incrementing,
     * without specific business meaning
     */
    readonly id: number;
    /**
     * The name of current BookStore.
     * 
     * <p>This property forms a unique constraint,
     * which is {@code @Key} of Jimmer</p>
     */
    readonly name: string;
    readonly website?: string | undefined;
}
