# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20150819084709) do

  create_table "conductors", force: true do |t|
    t.string   "nombre"
    t.integer  "cedula"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "emergencia", force: true do |t|
    t.integer  "magnitud"
    t.string   "posicion"
    t.string   "tipo_vehiculo"
    t.string   "id_vehiculo"
    t.datetime "fecha"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "mobibuses", force: true do |t|
    t.string   "posicion"
    t.string   "estado"
    t.string   "kilms_ultima_revision"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "tranvia", force: true do |t|
    t.string   "identificacion"
    t.string   "linea"
    t.float    "kilms_ultima_revision"
    t.float    "temperatura"
    t.string   "posicion"
    t.string   "estado"
    t.boolean  "boton_panico"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "usuarios", force: true do |t|
    t.string   "nombre"
    t.string   "documento"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "vcubs", force: true do |t|
    t.string   "posicion"
    t.string   "estado"
    t.boolean  "prestada"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

end
