/**
 * Simple TreeNode DTO defined by DTO Language
 */
export interface SimpleTreeNodeView {
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
}
