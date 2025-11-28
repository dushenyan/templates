/**
 * Recursive TreeNode DTO defined by DTO Language
 */
export interface RecursiveTreeNodeView {
    /**
     * The surrogate id of the current object,
     * auto-incrementing,
     * without specific business meaning
     */
    readonly id: number;
    /**
     * The name of current TreeNode.
     * 
     * <p>This property forms a unique constraint,
     * which is {@code @Key} of Jimmer</p>
     */
    readonly name: string;
    /**
     * The child nodes of the current TreeNode.
     * The type of the associated object is the
     * same as the current object type, so it
     * is a self-associated property that can
     * be queried recursively.
     */
    readonly childNodes?: ReadonlyArray<RecursiveTreeNodeView> | undefined;
}
