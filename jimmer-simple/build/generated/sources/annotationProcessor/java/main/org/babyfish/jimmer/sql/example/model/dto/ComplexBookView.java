package org.babyfish.jimmer.sql.example.model.dto;

import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.babyfish.jimmer.View;
import org.babyfish.jimmer.client.Description;
import org.babyfish.jimmer.impl.util.DtoPropAccessor;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.meta.PropId;
import org.babyfish.jimmer.runtime.ImmutableSpi;
import org.babyfish.jimmer.sql.example.model.Author;
import org.babyfish.jimmer.sql.example.model.AuthorDraft;
import org.babyfish.jimmer.sql.example.model.AuthorFetcher;
import org.babyfish.jimmer.sql.example.model.Book;
import org.babyfish.jimmer.sql.example.model.BookDraft;
import org.babyfish.jimmer.sql.example.model.BookFetcher;
import org.babyfish.jimmer.sql.example.model.BookStore;
import org.babyfish.jimmer.sql.example.model.BookStoreDraft;
import org.babyfish.jimmer.sql.example.model.BookStoreFetcher;
import org.babyfish.jimmer.sql.example.model.Gender;
import org.babyfish.jimmer.sql.fetcher.DtoMetadata;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

@GeneratedBy(
        file = "<jimmer-simple>/src/main/dto/Book.dto"
)
@Description("Complex Book DTO defined by DTO Language\n")
public class ComplexBookView implements View<Book> {
    public static final DtoMetadata<Book, ComplexBookView> METADATA = 
        new DtoMetadata<Book, ComplexBookView>(
            BookFetcher.$
                .name()
                .edition()
                .price()
                .store(TargetOf_store.METADATA.getFetcher())
                .authors(TargetOf_authors.METADATA.getFetcher()),
            ComplexBookView::new
    );

    private static final DtoPropAccessor STORE_ACCESSOR = new DtoPropAccessor(
        true,
        new int[] { BookDraft.Producer.SLOT_STORE },
        DtoPropAccessor.<BookStore, TargetOf_store>objectReferenceGetter(TargetOf_store::new),
        DtoPropAccessor.objectReferenceSetter(TargetOf_store::toEntity)
    );

    private static final DtoPropAccessor AUTHORS_ACCESSOR = new DtoPropAccessor(
        true,
        new int[] { BookDraft.Producer.SLOT_AUTHORS },
        DtoPropAccessor.<Author, TargetOf_authors>objectListGetter(TargetOf_authors::new),
        DtoPropAccessor.objectListSetter(TargetOf_authors::toEntity)
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

    /**
     * The edition of current Book.
     *
     * <p>This property forms a unique constraint together with
     * the {@code name} property, which is {@code @Key} of Jimmer</p>
     */
    private Integer edition;

    private BigDecimal price;

    /**
     * The bookstore to which the current book belongs,
     * representing a many-to-one association
     */
    private TargetOf_store store;

    /**
     * All authors who participated in writing
     * the current book,
     * representing a many-to-many association
     */
    private List<TargetOf_authors> authors;

    public ComplexBookView() {
    }

    public ComplexBookView(@NonNull Book base) {
        this.id = base.id();
        this.name = base.name();
        this.edition = base.edition();
        this.price = base.price();
        this.store = STORE_ACCESSOR.get(base);
        this.authors = AUTHORS_ACCESSOR.get(base);
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

    @Description("The edition of current Book.\n"
                    + "\n"
                    + "<p>This property forms a unique constraint together with\n"
                    + "the {@code name} property, which is {@code @Key} of Jimmer</p>\n")
    public int getEdition() {
        if (edition == null) {
            throw new IllegalStateException("The property \"edition\" is not specified");
        }
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @NonNull
    public BigDecimal getPrice() {
        if (price == null) {
            throw new IllegalStateException("The property \"price\" is not specified");
        }
        return price;
    }

    public void setPrice(@NonNull BigDecimal price) {
        this.price = price;
    }

    @Description("The bookstore to which the current book belongs,\n"
                    + "representing a many-to-one association\n")
    @Nullable
    public TargetOf_store getStore() {
        return store;
    }

    public void setStore(@Nullable TargetOf_store store) {
        this.store = store;
    }

    @Description("All authors who participated in writing\n"
                    + "the current book,\n"
                    + "representing a many-to-many association\n")
    @NonNull
    public List<TargetOf_authors> getAuthors() {
        if (authors == null) {
            throw new IllegalStateException("The property \"authors\" is not specified");
        }
        return authors;
    }

    public void setAuthors(@NonNull List<TargetOf_authors> authors) {
        this.authors = authors;
    }

    @Override
    public Book toEntity() {
        return BookDraft.$.produce(__draft -> {
            __draft.setId(this.id);
            __draft.setName(this.name);
            __draft.setEdition(this.edition);
            __draft.setPrice(this.price);
            STORE_ACCESSOR.set(__draft, this.store);
            AUTHORS_ACCESSOR.set(__draft, this.authors != null ? this.authors : Collections.emptyList());
        });
    }

    @Override
    public int hashCode() {
        int hash = Long.hashCode(id);
        hash = hash * 31 + Objects.hashCode(name);
        hash = hash * 31 + Integer.hashCode(edition);
        hash = hash * 31 + Objects.hashCode(price);
        hash = hash * 31 + Objects.hashCode(store);
        hash = hash * 31 + Objects.hashCode(authors);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        ComplexBookView other = (ComplexBookView) o;
        if (!Objects.equals(id, other.id)) {
            return false;
        }
        if (!Objects.equals(name, other.name)) {
            return false;
        }
        if (!Objects.equals(edition, other.edition)) {
            return false;
        }
        if (!Objects.equals(price, other.price)) {
            return false;
        }
        if (!Objects.equals(store, other.store)) {
            return false;
        }
        if (!Objects.equals(authors, other.authors)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ComplexBookView").append('(');
        builder.append("").append("id=").append(id);
        builder.append(", ").append("name=").append(name);
        builder.append(", ").append("edition=").append(edition);
        builder.append(", ").append("price=").append(price);
        builder.append(", ").append("store=").append(store);
        builder.append(", ").append("authors=").append(authors);
        builder.append(')');
        return builder.toString();
    }

    @GeneratedBy
    public static class TargetOf_store implements View<BookStore> {
        public static final DtoMetadata<BookStore, TargetOf_store> METADATA = 
            new DtoMetadata<BookStore, TargetOf_store>(
                BookStoreFetcher.$
                    .name()
                    .website(),
                TargetOf_store::new
        );

        /**
         * The surrogate id of the current object,
         * auto-incrementing,
         * without specific business meaning
         */
        private Long id;

        /**
         * The name of current BookStore.
         *
         * <p>This property forms a unique constraint,
         * which is {@code @Key} of Jimmer</p>
         */
        private String name;

        private String website;

        public TargetOf_store() {
        }

        public TargetOf_store(@NonNull BookStore base) {
            this.id = base.id();
            this.name = base.name();
            this.website = ((ImmutableSpi)base).__isLoaded(PropId.byIndex(BookStoreDraft.Producer.SLOT_WEBSITE)) ? base.website() : null;
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

        @Description("The name of current BookStore.\n"
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

        @Nullable
        public String getWebsite() {
            return website;
        }

        public void setWebsite(@Nullable String website) {
            this.website = website;
        }

        @Override
        public BookStore toEntity() {
            return BookStoreDraft.$.produce(__draft -> {
                __draft.setId(this.id);
                __draft.setName(this.name);
                __draft.setWebsite(this.website);
            });
        }

        @Override
        public int hashCode() {
            int hash = Long.hashCode(id);
            hash = hash * 31 + Objects.hashCode(name);
            hash = hash * 31 + Objects.hashCode(website);
            return hash;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            TargetOf_store other = (TargetOf_store) o;
            if (!Objects.equals(id, other.id)) {
                return false;
            }
            if (!Objects.equals(name, other.name)) {
                return false;
            }
            if (!Objects.equals(website, other.website)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("ComplexBookView.TargetOf_store").append('(');
            builder.append("").append("id=").append(id);
            builder.append(", ").append("name=").append(name);
            builder.append(", ").append("website=").append(website);
            builder.append(')');
            return builder.toString();
        }
    }

    @GeneratedBy
    public static class TargetOf_authors implements View<Author> {
        public static final DtoMetadata<Author, TargetOf_authors> METADATA = 
            new DtoMetadata<Author, TargetOf_authors>(
                AuthorFetcher.$
                    .firstName()
                    .lastName()
                    .gender(),
                TargetOf_authors::new
        );

        /**
         * The surrogate id of the current object,
         * auto-incrementing,
         * without specific business meaning
         */
        private Long id;

        /**
         * The first name of current Author.
         *
         * <p>This property forms a unique constraint together with
         * the {@code lastName} property, which is {@code @Key} of Jimmer</p>
         */
        private String firstName;

        /**
         * The last name of current Book.
         *
         * <p>This property forms a unique constraint together with
         * the {@code firstName} property, which is {@code @Key} of Jimmer</p>
         */
        private String lastName;

        private Gender gender;

        public TargetOf_authors() {
        }

        public TargetOf_authors(@NonNull Author base) {
            this.id = base.id();
            this.firstName = base.firstName();
            this.lastName = base.lastName();
            this.gender = base.gender();
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

        @Description("The first name of current Author.\n"
                        + "\n"
                        + "<p>This property forms a unique constraint together with\n"
                        + "the {@code lastName} property, which is {@code @Key} of Jimmer</p>\n")
        @NonNull
        public String getFirstName() {
            if (firstName == null) {
                throw new IllegalStateException("The property \"firstName\" is not specified");
            }
            return firstName;
        }

        public void setFirstName(@NonNull String firstName) {
            this.firstName = firstName;
        }

        @Description("The last name of current Book.\n"
                        + "\n"
                        + "<p>This property forms a unique constraint together with\n"
                        + "the {@code firstName} property, which is {@code @Key} of Jimmer</p>\n")
        @NonNull
        public String getLastName() {
            if (lastName == null) {
                throw new IllegalStateException("The property \"lastName\" is not specified");
            }
            return lastName;
        }

        public void setLastName(@NonNull String lastName) {
            this.lastName = lastName;
        }

        @NonNull
        public Gender getGender() {
            if (gender == null) {
                throw new IllegalStateException("The property \"gender\" is not specified");
            }
            return gender;
        }

        public void setGender(@NonNull Gender gender) {
            this.gender = gender;
        }

        @Override
        public Author toEntity() {
            return AuthorDraft.$.produce(__draft -> {
                __draft.setId(this.id);
                __draft.setFirstName(this.firstName);
                __draft.setLastName(this.lastName);
                __draft.setGender(this.gender);
            });
        }

        @Override
        public int hashCode() {
            int hash = Long.hashCode(id);
            hash = hash * 31 + Objects.hashCode(firstName);
            hash = hash * 31 + Objects.hashCode(lastName);
            hash = hash * 31 + Objects.hashCode(gender);
            return hash;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            TargetOf_authors other = (TargetOf_authors) o;
            if (!Objects.equals(id, other.id)) {
                return false;
            }
            if (!Objects.equals(firstName, other.firstName)) {
                return false;
            }
            if (!Objects.equals(lastName, other.lastName)) {
                return false;
            }
            if (!Objects.equals(gender, other.gender)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("ComplexBookView.TargetOf_authors").append('(');
            builder.append("").append("id=").append(id);
            builder.append(", ").append("firstName=").append(firstName);
            builder.append(", ").append("lastName=").append(lastName);
            builder.append(", ").append("gender=").append(gender);
            builder.append(')');
            return builder.toString();
        }
    }
}
