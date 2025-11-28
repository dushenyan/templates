package org.babyfish.jimmer.sql.example.model.dto;

import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import org.babyfish.jimmer.View;
import org.babyfish.jimmer.client.Description;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.example.model.Book;
import org.babyfish.jimmer.sql.example.model.BookDraft;
import org.babyfish.jimmer.sql.example.model.BookFetcher;
import org.babyfish.jimmer.sql.fetcher.DtoMetadata;
import org.jspecify.annotations.NonNull;

@GeneratedBy(
        file = "<jimmer-simple>/src/main/dto/Book.dto"
)
@Description("Simple Book DTO defined by DTO Language\n")
public class SimpleBookView implements View<Book> {
    public static final DtoMetadata<Book, SimpleBookView> METADATA = 
        new DtoMetadata<Book, SimpleBookView>(
            BookFetcher.$
                .name(),
            SimpleBookView::new
    );

    /**
     * The surrogate id of the current object,
     * auto-incrementing,
     * without specific business meaning
     */
    private Long id;

    /**
     * The name of current Book.
     *
     * <p>This property forms a unique constraint together with
     * the {@code edition} property, which is {@code @Key} of Jimmer</p>
     */
    private String name;

    public SimpleBookView() {
    }

    public SimpleBookView(@NonNull Book base) {
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

    @Description("The name of current Book.\n"
                    + "\n"
                    + "<p>This property forms a unique constraint together with\n"
                    + "the {@code edition} property, which is {@code @Key} of Jimmer</p>\n")
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
    public Book toEntity() {
        return BookDraft.$.produce(__draft -> {
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
        SimpleBookView other = (SimpleBookView) o;
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
        builder.append("SimpleBookView").append('(');
        builder.append("").append("id=").append(id);
        builder.append(", ").append("name=").append(name);
        builder.append(')');
        return builder.toString();
    }
}
