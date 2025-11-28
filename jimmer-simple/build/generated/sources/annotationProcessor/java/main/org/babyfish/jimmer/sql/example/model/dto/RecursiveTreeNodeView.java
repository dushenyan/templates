package org.babyfish.jimmer.sql.example.model.dto;

import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.babyfish.jimmer.View;
import org.babyfish.jimmer.client.Description;
import org.babyfish.jimmer.impl.util.DtoPropAccessor;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.example.model.TreeNode;
import org.babyfish.jimmer.sql.example.model.TreeNodeDraft;
import org.babyfish.jimmer.sql.example.model.TreeNodeFetcher;
import org.babyfish.jimmer.sql.fetcher.DtoMetadata;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

@GeneratedBy(
        file = "<jimmer-simple>/src/main/dto/TreeNode.dto"
)
@Description("Recursive TreeNode DTO defined by DTO Language\n")
public class RecursiveTreeNodeView implements View<TreeNode> {
    public static final DtoMetadata<TreeNode, RecursiveTreeNodeView> METADATA = 
        new DtoMetadata<TreeNode, RecursiveTreeNodeView>(
            TreeNodeFetcher.$
                .name()
                .recursiveChildNodes(),
            RecursiveTreeNodeView::new
    );

    private static final DtoPropAccessor CHILD_NODES_ACCESSOR = new DtoPropAccessor(
        false,
        new int[] { TreeNodeDraft.Producer.SLOT_CHILD_NODES },
        DtoPropAccessor.<TreeNode, RecursiveTreeNodeView>objectListGetter(RecursiveTreeNodeView::new),
        DtoPropAccessor.objectListSetter(RecursiveTreeNodeView::toEntity)
    );

    /**
     * The surrogate id of the current object,
     * auto-incrementing,
     * without specific business meaning
     */
    private Long id;

    /**
     * The name of current TreeNode.
     *
     * <p>This property forms a unique constraint,
     * which is {@code @Key} of Jimmer</p>
     */
    private String name;

    /**
     * The child nodes of the current TreeNode.
     * The type of the associated object is the
     * same as the current object type, so it
     * is a self-associated property that can
     * be queried recursively.
     */
    private List<RecursiveTreeNodeView> childNodes;

    public RecursiveTreeNodeView() {
    }

    public RecursiveTreeNodeView(@NonNull TreeNode base) {
        this.id = base.id();
        this.name = base.name();
        this.childNodes = CHILD_NODES_ACCESSOR.get(base);
    }

    @Description("The surrogate id of the current object,\n"
                    + "auto-incrementing,\n"
                    + "without specific business meaning\n")
    public long getId() {
        if (id == null) {
            throw new IllegalStateException("The property \"id\" is not specified");
        }
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Description("The name of current TreeNode.\n"
                    + "\n"
                    + "<p>This property forms a unique constraint,\n"
                    + "which is {@code @Key} of Jimmer</p>\n")
    @NonNull
    public String getName() {
        if (name == null) {
            throw new IllegalStateException("The property \"name\" is not specified");
        }
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @Description("The child nodes of the current TreeNode.\n"
                    + "The type of the associated object is the\n"
                    + "same as the current object type, so it\n"
                    + "is a self-associated property that can\n"
                    + "be queried recursively.\n")
    @Nullable
    public List<RecursiveTreeNodeView> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(@Nullable List<RecursiveTreeNodeView> childNodes) {
        this.childNodes = childNodes;
    }

    @Override
    public TreeNode toEntity() {
        return TreeNodeDraft.$.produce(__draft -> {
            __draft.setId(this.id);
            __draft.setName(this.name);
            CHILD_NODES_ACCESSOR.set(__draft, this.childNodes != null ? this.childNodes : Collections.emptyList());
        });
    }

    @Override
    public int hashCode() {
        int hash = Long.hashCode(id);
        hash = hash * 31 + Objects.hashCode(name);
        hash = hash * 31 + Objects.hashCode(childNodes);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        RecursiveTreeNodeView other = (RecursiveTreeNodeView) o;
        if (!Objects.equals(id, other.id)) {
            return false;
        }
        if (!Objects.equals(name, other.name)) {
            return false;
        }
        if (!Objects.equals(childNodes, other.childNodes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RecursiveTreeNodeView").append('(');
        builder.append("").append("id=").append(id);
        builder.append(", ").append("name=").append(name);
        builder.append(", ").append("childNodes=").append(childNodes);
        builder.append(')');
        return builder.toString();
    }
}
