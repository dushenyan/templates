package org.babyfish.jimmer.sql.example.model.dto;

import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import org.babyfish.jimmer.View;
import org.babyfish.jimmer.client.Description;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.example.model.TreeNode;
import org.babyfish.jimmer.sql.example.model.TreeNodeDraft;
import org.babyfish.jimmer.sql.example.model.TreeNodeFetcher;
import org.babyfish.jimmer.sql.fetcher.DtoMetadata;
import org.jspecify.annotations.NonNull;

@GeneratedBy(
        file = "<jimmer-simple>/src/main/dto/TreeNode.dto"
)
@Description("Simple TreeNode DTO defined by DTO Language\n")
public class SimpleTreeNodeView implements View<TreeNode> {
    public static final DtoMetadata<TreeNode, SimpleTreeNodeView> METADATA = 
        new DtoMetadata<TreeNode, SimpleTreeNodeView>(
            TreeNodeFetcher.$
                .name(),
            SimpleTreeNodeView::new
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

    public SimpleTreeNodeView() {
    }

    public SimpleTreeNodeView(@NonNull TreeNode base) {
        this.id = base.id();
        this.name = base.name();
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

    @Override
    public TreeNode toEntity() {
        return TreeNodeDraft.$.produce(__draft -> {
            __draft.setId(this.id);
            __draft.setName(this.name);
        });
    }

    @Override
    public int hashCode() {
        int hash = Long.hashCode(id);
        hash = hash * 31 + Objects.hashCode(name);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        SimpleTreeNodeView other = (SimpleTreeNodeView) o;
        if (!Objects.equals(id, other.id)) {
            return false;
        }
        if (!Objects.equals(name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SimpleTreeNodeView").append('(');
        builder.append("").append("id=").append(id);
        builder.append(", ").append("name=").append(name);
        builder.append(')');
        return builder.toString();
    }
}
