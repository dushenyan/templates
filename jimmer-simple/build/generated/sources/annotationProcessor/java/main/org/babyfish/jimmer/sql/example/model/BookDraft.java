package org.babyfish.jimmer.sql.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.lang.CloneNotSupportedException;
import java.lang.Cloneable;
import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.System;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.babyfish.jimmer.CircularReferenceException;
import org.babyfish.jimmer.Draft;
import org.babyfish.jimmer.DraftConsumer;
import org.babyfish.jimmer.ImmutableObjects;
import org.babyfish.jimmer.UnloadedException;
import org.babyfish.jimmer.client.Description;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.jackson.ImmutableModuleRequiredException;
import org.babyfish.jimmer.lang.OldChain;
import org.babyfish.jimmer.meta.ImmutablePropCategory;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.PropId;
import org.babyfish.jimmer.runtime.DraftContext;
import org.babyfish.jimmer.runtime.DraftSpi;
import org.babyfish.jimmer.runtime.ImmutableSpi;
import org.babyfish.jimmer.runtime.Internal;
import org.babyfish.jimmer.runtime.NonSharedList;
import org.babyfish.jimmer.runtime.Visibility;
import org.babyfish.jimmer.sql.ManyToMany;
import org.babyfish.jimmer.sql.ManyToOne;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

@GeneratedBy(
        type = Book.class
)
public interface BookDraft extends Book, Draft {
    BookDraft.Producer $ = Producer.INSTANCE;

    @OldChain
    BookDraft setId(long id);

    @OldChain
    BookDraft setName(String name);

    @OldChain
    BookDraft setEdition(int edition);

    @OldChain
    BookDraft setPrice(BigDecimal price);

    @Nullable
    BookStoreDraft store();

    BookStoreDraft store(boolean autoCreate);

    @OldChain
    BookDraft setStore(BookStore store);

    @Nullable
    @JsonIgnore
    Long storeId();

    @OldChain
    BookDraft setStoreId(@Nullable Long storeId);

    @OldChain
    BookDraft applyStore(DraftConsumer<BookStoreDraft> block);

    @OldChain
    BookDraft applyStore(BookStore base, DraftConsumer<BookStoreDraft> block);

    List<AuthorDraft> authors(boolean autoCreate);

    @OldChain
    BookDraft setAuthors(List<Author> authors);

    @OldChain
    BookDraft addIntoAuthors(DraftConsumer<AuthorDraft> block);

    @OldChain
    BookDraft addIntoAuthors(Author base, DraftConsumer<AuthorDraft> block);

    @GeneratedBy(
            type = Book.class
    )
    class Producer {
        static final Producer INSTANCE = new Producer();

        public static final int SLOT_ID = 0;

        public static final int SLOT_NAME = 1;

        public static final int SLOT_EDITION = 2;

        public static final int SLOT_PRICE = 3;

        public static final int SLOT_STORE = 4;

        public static final int SLOT_AUTHORS = 5;

        public static final ImmutableType TYPE = ImmutableType
            .newBuilder(
                "0.9.114",
                Book.class,
                Collections.emptyList(),
                (ctx, base) -> new DraftImpl(ctx, (Book)base)
            )
            .id(SLOT_ID, "id", long.class)
            .key(SLOT_NAME, "name", String.class, false)
            .key(SLOT_EDITION, "edition", int.class, false)
            .add(SLOT_PRICE, "price", ImmutablePropCategory.SCALAR, BigDecimal.class, false)
            .add(SLOT_STORE, "store", ManyToOne.class, BookStore.class, true)
            .add(SLOT_AUTHORS, "authors", ManyToMany.class, Author.class, false)
            .build();

        private Producer() {
        }

        public Book produce(DraftConsumer<BookDraft> block) {
            return (Book)Internal.produce(TYPE, null, block);
        }

        public Book produce(Book base, DraftConsumer<BookDraft> block) {
            return (Book)Internal.produce(TYPE, base, block);
        }

        public Book produce(boolean resolveImmediately, DraftConsumer<BookDraft> block) {
            return (Book)Internal.produce(TYPE, null, resolveImmediately, block);
        }

        public Book produce(Book base, boolean resolveImmediately, DraftConsumer<BookDraft> block) {
            return (Book)Internal.produce(TYPE, base, resolveImmediately, block);
        }

        /**
         * Class, not interface, for free-marker
         */
        @GeneratedBy(
                type = Book.class
        )
        @JsonPropertyOrder({"dummyPropForJacksonError__", "id", "name", "edition", "price", "store", "authors"})
        public abstract static class Implementor implements Book, ImmutableSpi {
            @Override
            public final Object __get(PropId prop) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __get(prop.asName());
                    case SLOT_ID:
                    		return (Long)id();
                    case SLOT_NAME:
                    		return name();
                    case SLOT_EDITION:
                    		return (Integer)edition();
                    case SLOT_PRICE:
                    		return price();
                    case SLOT_STORE:
                    		return store();
                    case SLOT_AUTHORS:
                    		return authors();
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.Book\": \"" + prop + "\"");
                }
            }

            @Override
            public final Object __get(String prop) {
                switch (prop) {
                    case "id":
                    		return (Long)id();
                    case "name":
                    		return name();
                    case "edition":
                    		return (Integer)edition();
                    case "price":
                    		return price();
                    case "store":
                    		return store();
                    case "authors":
                    		return authors();
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.Book\": \"" + prop + "\"");
                }
            }

            public final long getId() {
                return id();
            }

            public final String getName() {
                return name();
            }

            public final int getEdition() {
                return edition();
            }

            public final BigDecimal getPrice() {
                return price();
            }

            @org.jetbrains.annotations.Nullable
            public final BookStore getStore() {
                return store();
            }

            public final List<Author> getAuthors() {
                return authors();
            }

            @Override
            public final ImmutableType __type() {
                return TYPE;
            }

            public final int getDummyPropForJacksonError__() {
                throw new ImmutableModuleRequiredException();
            }
        }

        @GeneratedBy(
                type = Book.class
        )
        private static class Impl extends Implementor implements Cloneable, Serializable {
            private Visibility __visibility;

            long __idValue;

            boolean __idLoaded = false;

            String __nameValue;

            int __editionValue;

            boolean __editionLoaded = false;

            BigDecimal __priceValue;

            BookStore __storeValue;

            boolean __storeLoaded = false;

            NonSharedList<Author> __authorsValue;

            @Override
            @JsonIgnore
            @Description("The surrogate id of the current object,\n"
                            + "auto-incrementing,\n"
                            + "without specific business meaning")
            public long id() {
                if (!__idLoaded) {
                    throw new UnloadedException(Book.class, "id");
                }
                return __idValue;
            }

            @Override
            @JsonIgnore
            @Description("The name of current Book.\n"
                            + "\n"
                            + "<p>This property forms a unique constraint together with\n"
                            + "the {@code edition} property, which is {@code @Key} of Jimmer</p>")
            public String name() {
                if (__nameValue == null) {
                    throw new UnloadedException(Book.class, "name");
                }
                return __nameValue;
            }

            @Override
            @JsonIgnore
            @Description("The edition of current Book.\n"
                            + "\n"
                            + "<p>This property forms a unique constraint together with\n"
                            + "the {@code name} property, which is {@code @Key} of Jimmer</p>")
            public int edition() {
                if (!__editionLoaded) {
                    throw new UnloadedException(Book.class, "edition");
                }
                return __editionValue;
            }

            @Override
            @JsonIgnore
            public BigDecimal price() {
                if (__priceValue == null) {
                    throw new UnloadedException(Book.class, "price");
                }
                return __priceValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            @Description("The bookstore to which the current book belongs,\n"
                            + "representing a many-to-one association")
            public BookStore store() {
                if (!__storeLoaded) {
                    throw new UnloadedException(Book.class, "store");
                }
                return __storeValue;
            }

            @Override
            @JsonIgnore
            @Description("All authors who participated in writing\n"
                            + "the current book,\n"
                            + "representing a many-to-many association")
            public List<Author> authors() {
                if (__authorsValue == null) {
                    throw new UnloadedException(Book.class, "authors");
                }
                return __authorsValue;
            }

            @Override
            public Impl clone() {
                try {
                    Impl copy = (Impl) super.clone();
                    Visibility originalVisibility = this.__visibility;
                    if (originalVisibility != null) {
                        Visibility newVisibility = Visibility.of(6);
                        for (int propId = 0; propId < 6; propId++) {
                            newVisibility.show(propId, originalVisibility.visible(propId));
                        }
                        copy.__visibility = newVisibility;
                    } else {
                        copy.__visibility = null;
                    }
                    return copy;
                } catch(CloneNotSupportedException ex) {
                    throw new AssertionError(ex);
                }
            }

            @Override
            public boolean __isLoaded(PropId prop) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __isLoaded(prop.asName());
                    case SLOT_ID:
                    		return __idLoaded;
                    case SLOT_NAME:
                    		return __nameValue != null;
                    case SLOT_EDITION:
                    		return __editionLoaded;
                    case SLOT_PRICE:
                    		return __priceValue != null;
                    case SLOT_STORE:
                    		return __storeLoaded;
                    case SLOT_AUTHORS:
                    		return __authorsValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.Book\": \"" + prop + "\"");
                }
            }

            @Override
            public boolean __isLoaded(String prop) {
                switch (prop) {
                    case "id":
                    		return __idLoaded;
                    case "name":
                    		return __nameValue != null;
                    case "edition":
                    		return __editionLoaded;
                    case "price":
                    		return __priceValue != null;
                    case "store":
                    		return __storeLoaded;
                    case "authors":
                    		return __authorsValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.Book\": \"" + prop + "\"");
                }
            }

            @Override
            public boolean __isVisible(PropId prop) {
                if (__visibility == null) {
                    return true;
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __isVisible(prop.asName());
                    case SLOT_ID:
                    		return __visibility.visible(SLOT_ID);
                    case SLOT_NAME:
                    		return __visibility.visible(SLOT_NAME);
                    case SLOT_EDITION:
                    		return __visibility.visible(SLOT_EDITION);
                    case SLOT_PRICE:
                    		return __visibility.visible(SLOT_PRICE);
                    case SLOT_STORE:
                    		return __visibility.visible(SLOT_STORE);
                    case SLOT_AUTHORS:
                    		return __visibility.visible(SLOT_AUTHORS);
                    default: return true;
                }
            }

            @Override
            public boolean __isVisible(String prop) {
                if (__visibility == null) {
                    return true;
                }
                switch (prop) {
                    case "id":
                    		return __visibility.visible(SLOT_ID);
                    case "name":
                    		return __visibility.visible(SLOT_NAME);
                    case "edition":
                    		return __visibility.visible(SLOT_EDITION);
                    case "price":
                    		return __visibility.visible(SLOT_PRICE);
                    case "store":
                    		return __visibility.visible(SLOT_STORE);
                    case "authors":
                    		return __visibility.visible(SLOT_AUTHORS);
                    default: return true;
                }
            }

            @Override
            public int hashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__idLoaded) {
                    hash = 31 * hash + Long.hashCode(__idValue);
                    // If entity-id is loaded, return directly
                    return hash;
                }
                if (__nameValue != null) {
                    hash = 31 * hash + __nameValue.hashCode();
                }
                if (__editionLoaded) {
                    hash = 31 * hash + Integer.hashCode(__editionValue);
                }
                if (__priceValue != null) {
                    hash = 31 * hash + __priceValue.hashCode();
                }
                if (__storeLoaded && __storeValue != null) {
                    hash = 31 * hash + __storeValue.hashCode();
                }
                if (__authorsValue != null) {
                    hash = 31 * hash + __authorsValue.hashCode();
                }
                return hash;
            }

            private int __shallowHashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__idLoaded) {
                    hash = 31 * hash + Long.hashCode(__idValue);
                }
                if (__nameValue != null) {
                    hash = 31 * hash + System.identityHashCode(__nameValue);
                }
                if (__editionLoaded) {
                    hash = 31 * hash + Integer.hashCode(__editionValue);
                }
                if (__priceValue != null) {
                    hash = 31 * hash + System.identityHashCode(__priceValue);
                }
                if (__storeLoaded) {
                    hash = 31 * hash + System.identityHashCode(__storeValue);
                }
                if (__authorsValue != null) {
                    hash = 31 * hash + System.identityHashCode(__authorsValue);
                }
                return hash;
            }

            @Override
            public int __hashCode(boolean shallow) {
                return shallow ? __shallowHashCode() : hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == null || !(obj instanceof Implementor)) {
                    return false;
                }
                Implementor __other = (Implementor)obj;
                if (__isVisible(PropId.byIndex(SLOT_ID)) != __other.__isVisible(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                boolean __idLoaded = this.__idLoaded;
                if (__idLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                if (__idLoaded) {
                    // If entity-id is loaded, return directly
                    return __idValue == __other.id();
                }
                if (__isVisible(PropId.byIndex(SLOT_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_NAME))) {
                    return false;
                }
                boolean __nameLoaded = __nameValue != null;
                if (__nameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_NAME))) {
                    return false;
                }
                if (__nameLoaded && !Objects.equals(__nameValue, __other.name())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_EDITION)) != __other.__isVisible(PropId.byIndex(SLOT_EDITION))) {
                    return false;
                }
                boolean __editionLoaded = this.__editionLoaded;
                if (__editionLoaded != __other.__isLoaded(PropId.byIndex(SLOT_EDITION))) {
                    return false;
                }
                if (__editionLoaded && __editionValue != __other.edition()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_PRICE)) != __other.__isVisible(PropId.byIndex(SLOT_PRICE))) {
                    return false;
                }
                boolean __priceLoaded = __priceValue != null;
                if (__priceLoaded != __other.__isLoaded(PropId.byIndex(SLOT_PRICE))) {
                    return false;
                }
                if (__priceLoaded && !Objects.equals(__priceValue, __other.price())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_STORE)) != __other.__isVisible(PropId.byIndex(SLOT_STORE))) {
                    return false;
                }
                boolean __storeLoaded = this.__storeLoaded;
                if (__storeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_STORE))) {
                    return false;
                }
                if (__storeLoaded && !Objects.equals(__storeValue, __other.store())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_AUTHORS)) != __other.__isVisible(PropId.byIndex(SLOT_AUTHORS))) {
                    return false;
                }
                boolean __authorsLoaded = __authorsValue != null;
                if (__authorsLoaded != __other.__isLoaded(PropId.byIndex(SLOT_AUTHORS))) {
                    return false;
                }
                if (__authorsLoaded && !Objects.equals(__authorsValue, __other.authors())) {
                    return false;
                }
                return true;
            }

            private boolean __shallowEquals(Object obj) {
                if (obj == null || !(obj instanceof Implementor)) {
                    return false;
                }
                Implementor __other = (Implementor)obj;
                if (__isVisible(PropId.byIndex(SLOT_ID)) != __other.__isVisible(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                boolean __idLoaded = this.__idLoaded;
                if (__idLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                if (__idLoaded && __idValue != __other.id()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_NAME))) {
                    return false;
                }
                boolean __nameLoaded = __nameValue != null;
                if (__nameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_NAME))) {
                    return false;
                }
                if (__nameLoaded && __nameValue != __other.name()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_EDITION)) != __other.__isVisible(PropId.byIndex(SLOT_EDITION))) {
                    return false;
                }
                boolean __editionLoaded = this.__editionLoaded;
                if (__editionLoaded != __other.__isLoaded(PropId.byIndex(SLOT_EDITION))) {
                    return false;
                }
                if (__editionLoaded && __editionValue != __other.edition()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_PRICE)) != __other.__isVisible(PropId.byIndex(SLOT_PRICE))) {
                    return false;
                }
                boolean __priceLoaded = __priceValue != null;
                if (__priceLoaded != __other.__isLoaded(PropId.byIndex(SLOT_PRICE))) {
                    return false;
                }
                if (__priceLoaded && __priceValue != __other.price()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_STORE)) != __other.__isVisible(PropId.byIndex(SLOT_STORE))) {
                    return false;
                }
                boolean __storeLoaded = this.__storeLoaded;
                if (__storeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_STORE))) {
                    return false;
                }
                if (__storeLoaded && __storeValue != __other.store()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_AUTHORS)) != __other.__isVisible(PropId.byIndex(SLOT_AUTHORS))) {
                    return false;
                }
                boolean __authorsLoaded = __authorsValue != null;
                if (__authorsLoaded != __other.__isLoaded(PropId.byIndex(SLOT_AUTHORS))) {
                    return false;
                }
                if (__authorsLoaded && __authorsValue != __other.authors()) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean __equals(Object obj, boolean shallow) {
                return shallow ? __shallowEquals(obj) : equals(obj);
            }

            @Override
            public String toString() {
                return ImmutableObjects.toString(this);
            }
        }

        @GeneratedBy(
                type = Book.class
        )
        private static class DraftImpl extends Implementor implements DraftSpi, BookDraft {
            private DraftContext __ctx;

            private Impl __base;

            private Impl __modified;

            private boolean __resolving;

            private Book __resolved;

            DraftImpl(DraftContext ctx, Book base) {
                __ctx = ctx;
                if (base != null) {
                    __base = (Impl)base;
                }
                else {
                    __modified = new Impl();
                }
            }

            @Override
            public boolean __isLoaded(PropId prop) {
                return (__modified!= null ? __modified : __base).__isLoaded(prop);
            }

            @Override
            public boolean __isLoaded(String prop) {
                return (__modified!= null ? __modified : __base).__isLoaded(prop);
            }

            @Override
            public boolean __isVisible(PropId prop) {
                return (__modified!= null ? __modified : __base).__isVisible(prop);
            }

            @Override
            public boolean __isVisible(String prop) {
                return (__modified!= null ? __modified : __base).__isVisible(prop);
            }

            @Override
            public int hashCode() {
                return (__modified!= null ? __modified : __base).hashCode();
            }

            @Override
            public int __hashCode(boolean shallow) {
                return (__modified!= null ? __modified : __base).__hashCode(shallow);
            }

            @Override
            public boolean equals(Object obj) {
                return (__modified!= null ? __modified : __base).equals(obj);
            }

            @Override
            public boolean __equals(Object obj, boolean shallow) {
                return (__modified!= null ? __modified : __base).__equals(obj, shallow);
            }

            @Override
            public String toString() {
                return ImmutableObjects.toString(this);
            }

            @Override
            @JsonIgnore
            public long id() {
                return (__modified!= null ? __modified : __base).id();
            }

            @Override
            public BookDraft setId(long id) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__idValue = id;
                __tmpModified.__idLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            public String name() {
                return (__modified!= null ? __modified : __base).name();
            }

            @Override
            public BookDraft setName(String name) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (name == null) {
                    throw new IllegalArgumentException(
                        "'name' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__nameValue = name;
                return this;
            }

            @Override
            @JsonIgnore
            public int edition() {
                return (__modified!= null ? __modified : __base).edition();
            }

            @Override
            public BookDraft setEdition(int edition) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__editionValue = edition;
                __tmpModified.__editionLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            public BigDecimal price() {
                return (__modified!= null ? __modified : __base).price();
            }

            @Override
            public BookDraft setPrice(BigDecimal price) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (price == null) {
                    throw new IllegalArgumentException(
                        "'price' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__priceValue = price;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public BookStoreDraft store() {
                return __ctx.toDraftObject((__modified!= null ? __modified : __base).store());
            }

            @Override
            public BookStoreDraft store(boolean autoCreate) {
                if (autoCreate && (!__isLoaded(PropId.byIndex(SLOT_STORE)) || store() == null)) {
                    setStore(BookStoreDraft.$.produce(null, null));
                }
                return __ctx.toDraftObject((__modified!= null ? __modified : __base).store());
            }

            @Override
            public BookDraft setStore(BookStore store) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__storeValue = store;
                __tmpModified.__storeLoaded = true;
                return this;
            }

            @Nullable
            @JsonIgnore
            @Override
            public Long storeId() {
                BookStore store = store();
                if (store == null) {
                    return null;
                }
                return store.id();
            }

            @OldChain
            @Override
            public BookDraft setStoreId(@Nullable Long storeId) {
                if (storeId == null) {
                    setStore(null);
                    return this;
                }
                store(true).setId(storeId);
                return this;
            }

            @Override
            public BookDraft applyStore(DraftConsumer<BookStoreDraft> block) {
                applyStore(null, block);
                return this;
            }

            @Override
            public BookDraft applyStore(BookStore base, DraftConsumer<BookStoreDraft> block) {
                setStore(BookStoreDraft.$.produce(base, block));
                return this;
            }

            @Override
            @JsonIgnore
            public List<Author> authors() {
                return __ctx.toDraftList((__modified!= null ? __modified : __base).authors(), Author.class, true);
            }

            @Override
            public List<AuthorDraft> authors(boolean autoCreate) {
                if (autoCreate && (!__isLoaded(PropId.byIndex(SLOT_AUTHORS)))) {
                    setAuthors(new ArrayList<>());
                }
                return __ctx.toDraftList((__modified!= null ? __modified : __base).authors(), Author.class, true);
            }

            @Override
            public BookDraft setAuthors(List<Author> authors) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (authors == null) {
                    throw new IllegalArgumentException(
                        "'authors' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__authorsValue = NonSharedList.of(__tmpModified.__authorsValue, authors);
                return this;
            }

            @Override
            public BookDraft addIntoAuthors(DraftConsumer<AuthorDraft> block) {
                addIntoAuthors(null, block);
                return this;
            }

            @Override
            public BookDraft addIntoAuthors(Author base, DraftConsumer<AuthorDraft> block) {
                authors(true).add((AuthorDraft)AuthorDraft.$.produce(base, block));
                return this;
            }

            @SuppressWarnings("all")
            @Override
            public void __set(PropId prop, Object value) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__set(prop.asName(), value);
                    return;
                    case SLOT_ID:
                    		if (value == null) throw new IllegalArgumentException("'id' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setId((Long)value);
                            break;
                    case SLOT_NAME:
                    		setName((String)value);break;
                    case SLOT_EDITION:
                    		if (value == null) throw new IllegalArgumentException("'edition' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setEdition((Integer)value);
                            break;
                    case SLOT_PRICE:
                    		setPrice((BigDecimal)value);break;
                    case SLOT_STORE:
                    		setStore((BookStore)value);break;
                    case SLOT_AUTHORS:
                    		setAuthors((List<Author>)value);break;
                    default: throw new IllegalArgumentException("Illegal property id for \"org.babyfish.jimmer.sql.example.model.Book\": \"" + prop + "\"");
                }
            }

            @SuppressWarnings("all")
            @Override
            public void __set(String prop, Object value) {
                switch (prop) {
                    case "id":
                    		if (value == null) throw new IllegalArgumentException("'id' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setId((Long)value);
                            break;
                    case "name":
                    		setName((String)value);break;
                    case "edition":
                    		if (value == null) throw new IllegalArgumentException("'edition' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setEdition((Integer)value);
                            break;
                    case "price":
                    		setPrice((BigDecimal)value);break;
                    case "store":
                    		setStore((BookStore)value);break;
                    case "authors":
                    		setAuthors((List<Author>)value);break;
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.Book\": \"" + prop + "\"");
                }
            }

            @Override
            public void __show(PropId prop, boolean visible) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Visibility __visibility = (__modified!= null ? __modified : __base).__visibility;
                if (__visibility == null) {
                    if (visible) {
                        return;
                    }
                    __modified().__visibility = __visibility = Visibility.of(6);
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__show(prop.asName(), visible);
                    return;
                    case SLOT_ID:
                    		__visibility.show(SLOT_ID, visible);break;
                    case SLOT_NAME:
                    		__visibility.show(SLOT_NAME, visible);break;
                    case SLOT_EDITION:
                    		__visibility.show(SLOT_EDITION, visible);break;
                    case SLOT_PRICE:
                    		__visibility.show(SLOT_PRICE, visible);break;
                    case SLOT_STORE:
                    		__visibility.show(SLOT_STORE, visible);break;
                    case SLOT_AUTHORS:
                    		__visibility.show(SLOT_AUTHORS, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property id for \"org.babyfish.jimmer.sql.example.model.Book\": \"" + 
                                prop + 
                                "\",it does not exists"
                            );
                }
            }

            @Override
            public void __show(String prop, boolean visible) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Visibility __visibility = (__modified!= null ? __modified : __base).__visibility;
                if (__visibility == null) {
                    if (visible) {
                        return;
                    }
                    __modified().__visibility = __visibility = Visibility.of(6);
                }
                switch (prop) {
                    case "id":
                    		__visibility.show(SLOT_ID, visible);break;
                    case "name":
                    		__visibility.show(SLOT_NAME, visible);break;
                    case "edition":
                    		__visibility.show(SLOT_EDITION, visible);break;
                    case "price":
                    		__visibility.show(SLOT_PRICE, visible);break;
                    case "store":
                    		__visibility.show(SLOT_STORE, visible);break;
                    case "authors":
                    		__visibility.show(SLOT_AUTHORS, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property name for \"org.babyfish.jimmer.sql.example.model.Book\": \"" + 
                                prop + 
                                "\",it does not exists"
                            );
                }
            }

            @Override
            public void __unload(PropId prop) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__unload(prop.asName());
                    return;
                    case SLOT_ID:
                    		__modified().__idValue = 0;
                    __modified().__idLoaded = false;break;
                    case SLOT_NAME:
                    		__modified().__nameValue = null;break;
                    case SLOT_EDITION:
                    		__modified().__editionValue = 0;
                    __modified().__editionLoaded = false;break;
                    case SLOT_PRICE:
                    		__modified().__priceValue = null;break;
                    case SLOT_STORE:
                    		__modified().__storeValue = null;
                    __modified().__storeLoaded = false;break;
                    case SLOT_AUTHORS:
                    		__modified().__authorsValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property id for \"org.babyfish.jimmer.sql.example.model.Book\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
                }
            }

            @Override
            public void __unload(String prop) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                switch (prop) {
                    case "id":
                    		__modified().__idValue = 0;
                    __modified().__idLoaded = false;break;
                    case "name":
                    		__modified().__nameValue = null;break;
                    case "edition":
                    		__modified().__editionValue = 0;
                    __modified().__editionLoaded = false;break;
                    case "price":
                    		__modified().__priceValue = null;break;
                    case "store":
                    		__modified().__storeValue = null;
                    __modified().__storeLoaded = false;break;
                    case "authors":
                    		__modified().__authorsValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property name for \"org.babyfish.jimmer.sql.example.model.Book\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
                }
            }

            @Override
            public DraftContext __draftContext() {
                return __ctx;
            }

            @Override
            public Object __resolve() {
                if (__resolved != null) {
                    return __resolved;
                }
                if (__resolving) {
                    throw new CircularReferenceException();
                }
                __resolving = true;
                try {
                    Implementor base = __base;
                    Impl __tmpModified = __modified;
                    if (__tmpModified == null) {
                        if (base.__isLoaded(PropId.byIndex(SLOT_STORE))) {
                            BookStore oldValue = base.store();
                            BookStore newValue = __ctx.resolveObject(oldValue);
                            if (oldValue != newValue) {
                                setStore(newValue);
                            }
                        }
                        if (base.__isLoaded(PropId.byIndex(SLOT_AUTHORS))) {
                            List<Author> oldValue = base.authors();
                            List<Author> newValue = __ctx.resolveList(oldValue);
                            if (oldValue != newValue) {
                                setAuthors(newValue);
                            }
                        }
                        __tmpModified = __modified;
                    }
                    else {
                        __tmpModified.__storeValue = __ctx.resolveObject(__tmpModified.__storeValue);
                        __tmpModified.__authorsValue = NonSharedList.of(__tmpModified.__authorsValue, __ctx.resolveList(__tmpModified.__authorsValue));
                    }
                    if (__base != null && __tmpModified == null) {
                        this.__resolved = base;
                        return base;
                    }
                    this.__resolved = __tmpModified;
                    return __tmpModified;
                }
                finally {
                    __resolving = false;
                }
            }

            @Override
            public boolean __isResolved() {
                return __resolved != null;
            }

            Impl __modified() {
                Impl __tmpModified = __modified;
                if (__tmpModified == null) {
                    __tmpModified = __base.clone();
                    __modified = __tmpModified;
                }
                return __tmpModified;
            }
        }
    }

    @GeneratedBy(
            type = Book.class
    )
    class Builder {
        private final Producer.DraftImpl __draft;

        public Builder() {
            this(null);
        }

        public Builder(@Nullable Book base) {
            __draft = new Producer.DraftImpl(null, base);
        }

        public Builder id(@NonNull Long id) {
            if (id != null) {
                __draft.setId(id);
            }
            return this;
        }

        public Builder name(@NonNull String name) {
            if (name != null) {
                __draft.setName(name);
            }
            return this;
        }

        public Builder edition(@NonNull Integer edition) {
            if (edition != null) {
                __draft.setEdition(edition);
            }
            return this;
        }

        public Builder price(@NonNull BigDecimal price) {
            if (price != null) {
                __draft.setPrice(price);
            }
            return this;
        }

        public Builder store(@Nullable BookStore store) {
            __draft.setStore(store);
            return this;
        }

        public Builder authors(@NonNull List<Author> authors) {
            if (authors != null) {
                __draft.setAuthors(authors);
            }
            return this;
        }

        public Book build() {
            return (Book)__draft.__modified();
        }
    }
}
