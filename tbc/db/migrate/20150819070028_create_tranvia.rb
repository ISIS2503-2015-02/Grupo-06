class CreateTranvia < ActiveRecord::Migration
  def change
    create_table :tranvia do |t|
      t.string :identificacion
      t.string :linea
      t.float :kilms_ultima_revision
      t.float :temperatura
      t.string :posicion
      t.string :estado
      t.boolean :boton_panico
      t.timestamps
    end

    create_table :mobibuses do |t|
      t.string :posicion
      t.string :estado
      t.string :kilms_ultima_revision

      t.timestamps
    end

    create_table :conductors do |t|
      t.string :nombre
      t.integer :cedula
      t.timestamps
    end

    create_table :conductortranvia do |t|
      t.belongs_to :tranvium, index: true
      t.belongs_to :conductor, index: true
    end

    create_table :conductormobibuses do |t|
      t.belongs_to :mobibus, index: true
      t.belongs_to :conductor, index: true
    end

    create_table :reportets do |t|
      t.belongs_to :tranvium, index: true
      t.date :fecha
      t.integer :trayectos
      t.time :tiempopromedio

      t.timestamps
    end

    create_table :reportems do |t|
      t.belongs_to :mobibus, index: true
      t.date :fecha
      t.integer :trayectos

      t.timestamps
    end
  end
end
