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

    create_table :conductor_tranvia do |t|
      t.belongs_to :tranvium, index: true
      t.integer :idTranvia
      t.belongs_to :conductor, index: true
      t.integer :idConductor
    end

    create_table :conductor_mobibuses do |t|
      t.belongs_to :mobibus, index: true
      t.integer :idMobibus
      t.belongs_to :conductor, index: true
      t.integer :idConductor
    end

    create_table :reportets do |t|
      t.belongs_to :tranvium, index: true
      t.integer :idTranvia
      t.date :fecha
      t.integer :trayectos
      t.time :tiempopromedio

      t.timestamps
    end

    create_table :reportems do |t|
      t.belongs_to :mobibus, index: true
      t.integer :idMobibus
      t.date :fecha
      t.integer :trayectos

      t.timestamps
    end
  end
end
